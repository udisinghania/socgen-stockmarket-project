export interface Company{
    id : string ;
    code: string | undefined;
    name : string | undefined;
    turnover : number | undefined;
    ceo : string | undefined;
    description : string | undefined;
    stockExchangeNames:string|undefined;
    boardOfDirectors : string| undefined;
    sector_id : string | undefined;
}