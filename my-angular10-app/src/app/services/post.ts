export class Post{
    title: string;
    text: string;
    category: string;
    author: string;

    constructor(title: string, text: string, category: string, author: string) {
       this.title = title;
       this.text = text;
       this.category = category;
       this.author = author;
     }
}