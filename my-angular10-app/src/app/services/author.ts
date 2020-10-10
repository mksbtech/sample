export class Author {
   id: string;
   firstName: string;
   lastName: string;

   constructor(id: string, firstName: string, lastName: string) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    getId(): string{
      return this.id;
    }

    getFirstName(): string{
      return this.firstName;
    }

    getLastNAme(): string{
      return this.lastName;
    }
}
