export class Restaurant {
    id: string;
    Name: string;
    description: string;
    image:string;
   

    constructor(id: string, Name: string, description: string,image:string) {
       this.id = id;
       this.Name = Name;
       this.description = description;
       this.image = image;
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
     public setImage(imageurl:string){
       this.image = imageurl;
     }
 }