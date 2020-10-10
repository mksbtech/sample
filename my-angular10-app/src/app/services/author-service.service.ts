import { Injectable } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Author} from './author';
import {Post} from './post';

@Injectable({
  providedIn: 'root'
})
export class AuthorServiceService {

  private authorListSubscription: Subscription;
  private readonly url: string = 'http://localhost:8082/author-service';

  constructor(private httpClient: HttpClient) {
  }
  public getAuthors(count: number, offset: number): Observable<any>{
    const defaultQuery = '{"query":"{authors(count:3,offset:2){id,firstName,lastName}}"}';
    const query = {"query":"{authors(count:"+count+",offset:"+offset+"){id,firstName,lastName}}"};
    const headers =  {
      headers: new  HttpHeaders({
        'Content-Type': 'application/json',
      Accept : 'application/json'})
    };
    if(offset === 0 || count === 0){
    return this.httpClient.post<any>(this.url,
      defaultQuery,
    headers);
    }else{
      return this.httpClient.post<any>(this.url,
        query,
        headers);
    }
  }

  public createPost(post: Post): Observable<any>{
    const query = {
      "query": " mutation {writePost(title:\""+post.title+"\",text:\""+post.text+"\",category:\""+post.category+"\",author:\""+post.author+"\"){id}}"
  };
    console.log('Saving to server');
    const headers =  {
      headers: new  HttpHeaders({
        'Content-Type': 'application/json',
      Accept : 'application/json'})
    };
    return this.httpClient.post<any>(this.url,
    query,
    headers);
  }

  public getPost(): Observable<any>{
    return new Observable<Post>();
  }
  }

  // addType(name: string): Observable<Author> {
  //   const body = JSON.stringify({ name });
  //   const headers = new Headers({ 'Content-Type': 'application/json'});
  //   // const options = new RequestOptions({ headers });

  //   return this.httpClient.post(this.url, body).subscribe(this.handleResponse);

  // }

  // handleResponse(handleResponse: any): Error {
  //   throw new Error('Method not implemented.');
  // }
  // private handleError(error: Response): Observable<Error> {
  //   console.error(error);
  //   return Observable.throw(error.json().error || 'Server error');
  // }


// }
