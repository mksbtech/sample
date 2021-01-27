export class Employee {
    // id: string;
    firstName: string;
    lastName: string;
    email: string;
    // createdOn: string;
    // updatedOn:string;
    // constructor(id: string, firstName: string, lastName: string,email:string,createdOn:string,updatedOn:string) {
    //    this.id = id;
    //    this.firstName = firstName;
    //    this.lastName = lastName;
    //    this.email = email;
    //    this.createdOn = createdOn;
    //    this.updatedOn = updatedOn;
    //  }

    constructor (firstName: string, lastName: string, email: string) {
      this.firstName = firstName
      this.lastName = lastName
      this.email = email
    }
  //  getId(): string{
  //    return this.id;
  //  }

  // public getFirstName (): string {
  //   return this.firstName
  // }
  // public setFirstName (value: string) {
  //   this.firstName = value
  // }

  // public getLasttName (): string {
  //   return this.lastName
  // }
  // public setLastName (value: string) {
  //    this.lastName = value
  // }

  // public getEmail (): string {
  //     return this.email;
  // }
  // public setEmail (value: string) {
  //     this.email = value;
  // }
}
