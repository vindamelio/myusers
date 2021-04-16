import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.css']
})
export class AddEditComponent implements OnInit {
  
  @Input('parentUser') public importedUser:User = new User("","");
  @Output() public childUser = new EventEmitter();

  public formModel:User=new User("","");

  myForm:FormGroup;
  public sendingUser:User=new User("","");
  public error: string = "";
  public msg: String = "";

  constructor(
    private fb:FormBuilder,
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
    ) {
    //this.user.id = 0;
    this.myForm = fb.group({
      account: ["", [Validators.required, Validators.maxLength(20)]],
      mail:["", [Validators.required, Validators.maxLength(20)]]
    })

    //this.copiaDati( this.importedUser,  this.formModel);
    //this.copiaDati( this.importedUser,  this.sendingUser);

  }


  ngOnInit(): void {
    localStorage.setItem("importedUser",JSON.stringify(this.importedUser));
    
  }

  public fireChildUser(){
    this.childUser.emit("User Saluta");
  }

  public sendData(){
    
    //this.formModel.id = this.importedUser.id;
    this.userProviderService.createUser(this.importedUser).subscribe(data => this.sendingUser=data, error => this.error=error);
    console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
  }

  public sendData2(){
    
    //this.sendingUser.id=this.formModel.id;
    this.sendingUser.account = this.myForm.get("account")?.value ;
    this.sendingUser.mail = this.myForm.get("mail")?.value ;
    console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
    
    this.userProviderService.createUser(this.sendingUser).subscribe(data => this.sendingUser=data, error => this.error=error);
    console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
    console.log(this.myForm.value);

  }

  public resetData(){
    this.formModel.id = 0;
    this.formModel.account = "";
    this.formModel.mail = "";
  }

  public resetData2(){
    this.myForm.reset();
  }

  public deleteData(){
    this.userProviderService.deleteUser(this.importedUser.id).subscribe(data => this.msg=data, error => this.error=error);
    this.router.navigate(["/home"]);
  }


  public printUser(){
    
    console.log("importedUser: id:" + this.importedUser.id + ", account:" + this.importedUser.account + ", mail:" + this.importedUser.mail);
    console.log("formModel: id:" + this.formModel.id + ", account:" + this.formModel.account + ", mail:" + this.formModel.mail);
    console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
 


  }

  

  private copiaDati( da:User,  a:User){

    a.id = da.id;
    a.account = da.account;
    a.mail = da.mail;
    
  }

}
