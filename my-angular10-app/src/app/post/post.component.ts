import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthorServiceService } from '../services/author-service.service';
import { Post } from '../services/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {
  public readonly myFormGroup: FormGroup;
  private authorService: AuthorServiceService;

  constructor(private readonly formBuilder: FormBuilder, authorService: AuthorServiceService) {
    this.authorService = authorService;
    this.myFormGroup = this.formBuilder.group({
        text: [],
        title: [],
        category: [],
        author: [],
        subgroupName: this.formBuilder.group({
            subfield2: [],
        }),
        myRequiredField: ['', Validators.required],
    });
    // this.retrieveData();
    // this.myFormGroup = formBuilder.group({
    //   post: formBuilder.group(new Post('', '', '', '')),
    //   requestType: '',
    //   text: ''
    // });
  }

  private retrieveData(): void {
    this.authorService.getPost()
        .subscribe((res: Post) => {
            // Assuming res has a structure like:
            // res = {
            //     field1: "some-string",
            //     field2: "other-string",
            //     subgroupName: {
            //         subfield2: "another-string"
            //     },
            // }
            // Values in res that don't line up to the form structure
            // are discarded. You can also pass in your own object you
            // construct ad-hoc.
            this.myFormGroup.patchValue(res);
        });
}
onSubmit(): void {
  // Make sure to create a deep copy of the form-model
  const result: Post = Object.assign({}, this.myFormGroup.value);
  this.authorService.createPost(new Post(result.title, result.text, result.category, result.author))
  .subscribe((): void => {
      alert('Saved!');
  });
  // result.personalData = Object.assign({}, result.personalData);

  // Do useful stuff with the gathered data
  console.log(result);
}

  ngOnInit(): void {
  }

}
