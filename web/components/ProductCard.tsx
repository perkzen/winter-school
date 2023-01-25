import React, { FC } from 'react';
import { Product } from '../api/products';

interface CardProps {
  product: Product;
  onClick: () => void;
}

const ProductCard: FC<CardProps> = ({ product, onClick }) => {
  return (
    <div
      className={
        'flex flex-row shadow-lg bg-gray-100 rounded py-3 px-5 hover:cursor-pointer'
      }
      onClick={onClick}
    >
      <div className={'flex flex-row justify-between w-full items-center'}>
        <div className={'flex flex-col'}>
          <p>{product.displayName}</p>
          <p>{product.manufacturer}</p>
        </div>
        <p>{product.description}</p>
        <p>{product.type}</p>
        <p>{product.quantity}</p>
        <p>{product.price} $</p>
      </div>
    </div>
  );
};

export default ProductCard;
