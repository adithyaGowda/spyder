import { ListRange } from '@angular/cdk/collections';

export class IdeaDetail{
    id:string;
    title:string;
    description:string;
    duration:string;
    domain:string;
    subdomain:string;
    cost:ConstrainDouble;
    role:ListRange;
    status:string;
    postedOn:Date;
    postedBy:string;
    location:string;
}