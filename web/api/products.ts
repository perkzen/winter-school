import { backend } from '../libs/axios';

export interface Product {
  id: string;
  displayName: string;
  description: string;
  manufacturer: string;
  quantity: number;
  price: number;
  type: string;
}

export class ProductsApi {
  static async getProducts(): Promise<Product[]> {
    const response = await backend.get('/products');
    return response.data;
  }

  static async getProduct(id: string): Promise<Product> {
    const response = await backend.get(`/products/${id}`);
    return response.data;
  }

  static async createProduct(product: Omit<Product, 'id'>): Promise<Product> {
    const response = await backend.post('/products', product);
    return response.data;
  }

  static async updateProduct(product: Product) {
    const response = await backend.put(`/products/${product.id}`, product);
    return response.data;
  }
}
