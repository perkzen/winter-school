import React, { FC } from 'react';
import { Product, ProductsApi } from '../api/products';
import { useForm } from 'react-hook-form';
import { useMutation } from 'react-query';
import toast from 'react-hot-toast';

interface ProductFormProps {
  product?: Product;
  isEdit?: boolean;
}

const ProductForm: FC<ProductFormProps> = ({ product, isEdit }) => {
  const { register, handleSubmit, formState, reset } = useForm<
    Omit<Product, 'id'>
  >({
    defaultValues: {
      displayName: product?.displayName,
      manufacturer: product?.manufacturer,
      description: product?.description,
      type: product?.type,
      quantity: product?.quantity,
      price: product?.price,
    },
  });

  const { dirtyFields } = formState;
  const isDisabled = isEdit && Object.keys(dirtyFields).length < 6;

  const { mutateAsync } = useMutation((newProduct: Omit<Product, 'id'>) =>
    ProductsApi.createProduct(newProduct)
  );

  const onSubmit = handleSubmit(async (data) => {
    await toast.promise(mutateAsync(data), {
      loading: 'Saving...',
      success: 'Saved!',
      error: 'Error',
    });
    reset();
  });

  return (
    <div className={'flex justify-center items-center w-full mt-5'}>
      <div className={'shadow-lg rounded-lg bg-white px-5 py-5 w-1/2'}>
        <form onSubmit={onSubmit}>
          <div className={'flex flex-col gap-3 mt-4'}>
            <input
              {...register('displayName')}
              placeholder={'Display name'}
              className={
                'shadow rounded-full py-1 px-2 border-[1px] border-gray-300'
              }
            />

            <input
              {...register('manufacturer')}
              placeholder={'Manufacturer'}
              className={
                'shadow rounded-full py-1 px-2 border-[1px] border-gray-300'
              }
            />
            <input
              {...register('type')}
              placeholder={'Type'}
              className={
                'shadow rounded-full py-1 px-2 border-[1px] border-gray-300'
              }
            />

            <input
              {...register('description')}
              placeholder={'Description'}
              className={
                'shadow rounded-full py-1 px-3 border-[1px] border-gray-300'
              }
            />
            <input
              {...register('quantity')}
              placeholder={'Quantity'}
              type={'number'}
              className={
                'shadow rounded-full py-1 px-3 border-[1px] border-gray-300'
              }
            />
            <input
              {...register('price')}
              placeholder={'Price'}
              type={'number'}
              step={'0.01'}
              className={
                'shadow rounded-full py-1 px-3 border-[1px] border-gray-300'
              }
            />
            <div className={'flex flex-row gap-8 w-full'}>
              <button
                className={
                  'shadow bg-green-500 rounded-full py-1 px-3 w-full ' +
                  (isDisabled ? 'opacity-50 cursor-not-allowed' : '')
                }
                disabled={isDisabled}
              >
                Save
              </button>
              {isEdit && (
                <button
                  className={'shadow bg-red-500 rounded-full py-1 px-3 w-full '}
                >
                  Delete
                </button>
              )}
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ProductForm;
