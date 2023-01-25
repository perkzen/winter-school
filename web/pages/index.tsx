import type { NextPage } from 'next';
import Header from '../components/header';
import ProductCard from '../components/ProductCard';
import { ProductsApi } from '../api/products';
import { useRouter } from 'next/router';
import { useQuery } from 'react-query';

const Home: NextPage = () => {
  const router = useRouter();
  const handleClick = (id: string) => {
    router.push(`/product/${id}`);
  };

  const { data: products } = useQuery('products', () => {
    return ProductsApi.getProducts();
  });

  return (
    <div className={'flex flex-col gap-4'}>
      <Header
        title={'Product inventory'}
        subtitle={'List of all your products in inventory'}
        buttonLabel={'Add product'}
        onClick={() => router.push('/product')}
      />
      {products?.map((p) => (
        <ProductCard key={p.id} product={p} onClick={() => handleClick(p.id)} />
      ))}
    </div>
  );
};

export default Home;
