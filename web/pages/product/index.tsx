import React from 'react';
import ProductForm from '../../components/ProductForm';
import Header from '../../components/header';

const AddProduct = () => {
  return (
    <>
      <Header
        title={'Add product'}
        subtitle={'Form to add new products to your inventory'}
      />
      <ProductForm />
    </>
  );
};

export default AddProduct;
