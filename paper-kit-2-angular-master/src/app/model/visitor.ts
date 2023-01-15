import { Address } from "./address";

export interface Visitor {
  id: number;
  name: string;
  lastName: string;
  email: string;
  password: string;
  photo: string;
  address: Address;
}
