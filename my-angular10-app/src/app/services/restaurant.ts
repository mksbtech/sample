export class Restaurant {
    id: string;
    Name: string;
    description: string;
    constructor(id: string, Name: string, description: string) {
       this.id = id;
       this.Name = Name;
       this.description = description;
     }

     getId(): string{
       return this.id;
     }

     getName(): string{
       return this.Name;
     }

     getRescription(): string{
       return this.description;
     }
 }
