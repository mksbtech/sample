import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Author } from '../services/author';
import {AuthorServiceService} from '../services/author-service.service';
import { Post } from '../services/post';
@Component({
  selector: 'app-sample-component',
  templateUrl: './sample-component.component.html',
  styleUrls: ['./sample-component.component.scss']
})
export class SampleComponentComponent implements OnInit {

  // @Input()
  // private results: Observable<any>;
     @Input()
     authorList = new Array<Author>();


     @Input()
     cols: string[] = ['Id', 'First Name', 'Last Name'];

     private count: number;
     private offset: number;

     private authorService: AuthorServiceService;


  constructor(private route: ActivatedRoute, authorService: AuthorServiceService ) {
    // this.results = authorService.getAuthors();
    this.authorService = authorService;
    this.route = route;
  }

  ngOnInit(): void {
    console.log(this.route.snapshot.queryParamMap.get('count'));
    this.count = parseInt(this.route.snapshot.queryParamMap.get('count'), 10);
    this.offset = parseInt(this.route.snapshot.queryParamMap.get('offset'), 10);
    console.log('count = ' + this.count);
    console.log('offset = ' + this.offset);
    // tslint:disable-next-line: use-isnan
    if ( isNaN(this.count) || isNaN(this.offset)){
      this.authorService.getAuthors(0, 0).subscribe(response =>
        {
          // console.log(response.data);
          this.authorList = response.data.authors.map(item =>
            {
              return new Author(
                  item.id,
                  item.firstName,
                  item.lastName
              );
            });
        });
    }else{
    this.authorService.getAuthors(this.count, this.offset).subscribe(response =>
      {
        // console.log(response.data);
        this.authorList = response.data.authors.map(item =>
          {
            return new Author(
                item.id,
                item.firstName,
                item.lastName
            );
          });
      });
    }
  }
  // ngOnInit(): void {
  //   this.results.subscribe(response =>
  //     {
  //       console.log(response.data);
  //       // this.employees = response.map(item =>
  //       // {
  //       //   return new Employee(
  //       //       item.id,
  //       //       item.name,
  //       //       item.status
  //       //   );
  //       // });
  //     });
  // }

}
