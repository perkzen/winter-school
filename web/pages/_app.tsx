import type { AppProps } from 'next/app';
import '../styles/globals.css';
import Layout from '../components/layout';
import { QueryClient, QueryClientProvider } from 'react-query';
import { Toaster } from 'react-hot-toast';

const queryClient = new QueryClient();

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <QueryClientProvider client={queryClient}>
      <Layout>
        <Component {...pageProps} />
        <Toaster position="top-right" reverseOrder={false} />
      </Layout>
    </QueryClientProvider>
  );
}

export default MyApp;
