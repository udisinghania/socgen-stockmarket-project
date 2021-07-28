import { Address } from "./Address";

export interface Stock_exchange{
    id : string;
    name : string ;
    brief : string ;
    remarks : string ;
    address : Address; 
}