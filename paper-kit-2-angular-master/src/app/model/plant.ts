import { Bill } from "./bill";
import { Category } from "./category";
import { Photos } from "./photos";

export interface Plant {
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  categories: Category[];
  bills: Bill[];
  comment: Comment[];
}
