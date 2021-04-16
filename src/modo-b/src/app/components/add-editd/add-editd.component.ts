import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ReactiveFormsModule, FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import {FormlyFieldConfig} from '@ngx-formly/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-add-editd',
  templateUrl: './add-editd.component.html',
  styleUrls: ['./add-editd.component.css']
})
export class AddEditdComponent implements OnInit {
  @Input('parentUserd') public importedUserd:User = new User("","");
  @Output() public childUserd = new EventEmitter();


  public sendingUserd:User=new User("","");
  public error: string = "";
  public msg: String = "";

  public stringd: String = "";

  //dfavoriteColorControlId = new FormControl('');
  //dfavoriteColorControlAccount = new FormControl('');
  //dfavoriteColorControlMail = new FormControl('');

  myForm = new FormGroup({});
  myModel = { 
    did: 0,
    dAccount: '',
    dMail: '' 
  
  };
  myFields: FormlyFieldConfig[] = [
    {
      key: 'did',
      type: 'input',
      templateOptions: {
        label: 'id',
        placeholder: 'Enter id',
        required: true,
      }
    },
    {
      key: 'dAccount',
      type: 'input',
      templateOptions: {
        label: 'Account',
        placeholder: 'Enter Account',
        required: true,
      }
    },
    {
      key: 'dMail',
      type: 'input',
      templateOptions: {
        label: 'Mail',
        placeholder: 'Enter Mail',
        required: true,
      }
    }
  ];

  constructor(
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
  ) { }

  ngOnInit(): void {
    localStorage.setItem("importedUserd",JSON.stringify(this.importedUserd));
    this.stringd = this.importedUserd.id + ":" + this.importedUserd.account + ":" + this.importedUserd.mail ;
    //this.dfavoriteColorControlId.setValue(this.importedUserd.id)
    //this.dfavoriteColorControlAccount.setValue(this.importedUserd.account)
    //this.dfavoriteColorControlMail.setValue(this.importedUserd.mail)
  }

  onSubmit() {
    //console.log(this.myModel);
    console.log(this.myModel);

  }

  public fireChildUser(){
    this.childUserd.emit("User " + this.importedUserd.account + " Saluta");
  }

  public sendData4(){
    //this.formModel.id = this.importedUser.id;
    //this.userProviderService.createUser(this.importedUserd).subscribe(data => this.sendingUser=data, error => this.error=error);
    //console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
    this.router.navigate(["/home"]);
  }

  

  public resetData4(){
    //this.formModel.id = 0;
    //this.formModel.account = "";
    //this.formModel.mail = "";
  }

  

  public deleteData(){
    this.userProviderService.deleteUser(this.importedUserd.id).subscribe(data => this.msg=data, error => this.error=error);
    this.router.navigate(["/home"]);
  }


  public printUser(){
    console.log("importedUserd: id:" + this.importedUserd.id + ", account:" + this.importedUserd.account + ", mail:" + this.importedUserd.mail);
    console.log("sendingUserd: id:" + this.sendingUserd.id + ", account:" + this.sendingUserd.account + ", mail:" + this.sendingUserd.mail);
  }

  public updateValue(){
    
    //this.dfavoriteColorControlId.setValue(this.importedUserd.id)
    //this.dfavoriteColorControlAccount.setValue(this.importedUserd.account)
    //this.dfavoriteColorControlMail.setValue(this.importedUserd.mail)
    this.myModel.did = this.importedUserd.id
    this.myModel.dAccount = this.importedUserd.account.toString()
    this.myModel.dMail = this.importedUserd.mail.toString()
    //this.myFields..push

    console.log(this.myForm.value)
  }


}
