import React from 'react';
import { useRouter } from 'next/router';
import { useQuery } from 'react-query';
import { ProductsApi } from '../../api/products';
import ProductForm from '../../components/ProductForm';
import Header from '../../components/header';

const Product = () => {
  const router = useRouter();
  const { id } = router.query;
  const { data: product, refetch: refetchProduct } = useQuery('product', () => {
    return ProductsApi.getProduct(id as string);
  });

  return (
    <>
      <Header
        title={'Edit product'}
        subtitle={'Edit existing product in your inventory'}
      />
      <ProductForm product={product} isEdit refetchProducts={refetchProduct} />
    </>
  );
};

export default Product;
