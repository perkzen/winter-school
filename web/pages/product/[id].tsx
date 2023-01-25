import React from 'react';
import { useRouter } from 'next/router';
import { useQuery } from 'react-query';
import { ProductsApi } from '../../api/products';

const Product = () => {
  const router = useRouter();
  const { id } = router.query;
  const { data: product } = useQuery('product', () => {
    return ProductsApi.getProduct(id as string);
  });

  return <div>{product?.displayName}</div>;
};

export default Product;
