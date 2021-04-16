import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-add-editc',
  templateUrl: './add-editc.component.html',
  styleUrls: ['./add-editc.component.css']
})
export class AddEditcComponent implements OnInit {
  @Input('parentUserc') public importedUserc:User = new User("","");
  @Output() public childUserc = new EventEmitter();

  public sendingUserc:User=new User("","");
  public error: string = "";
  public msg: String = "";

  public stringc: String = "";

  cfavoriteColorControlId = new FormControl('');
  cfavoriteColorControlAccount = new FormControl('');
  cfavoriteColorControlMail = new FormControl('');
  
  constructor(
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
  ) { }

  ngOnInit(): void {

    localStorage.setItem("importedUserc",JSON.stringify(this.importedUserc));
    this.stringc = this.importedUserc.id + ":" + this.importedUserc.account + ":" + this.importedUserc.mail ;
    this.cfavoriteColorControlId.setValue(this.importedUserc.id)
    this.cfavoriteColorControlAccount.setValue(this.importedUserc.account)
    this.cfavoriteColorControlMail.setValue(this.importedUserc.mail)
    
  }

  public fireChildUser(){
    this.childUserc.emit("User " + this.importedUserc.account + " Saluta");
  }


  public sendData3(){
    
    //this.sendingUser.id=this.formModel.id;
    this.sendingUserc.id=this.cfavoriteColorControlId.value;

    this.sendingUserc.account = this.cfavoriteColorControlAccount.value ;
    this.sendingUserc.mail = this.cfavoriteColorControlMail.value ;
    console.log("sendingUserb: id:" + this.sendingUserc.id + ", account:" + this.sendingUserc.account + ", mail:" + this.sendingUserc.mail);
    
    this.userProviderService.createUser(this.sendingUserc).subscribe(data => this.sendingUserc=data, error => this.error=error);
    console.log("sendingUserb: id:" + this.sendingUserc.id + ", account:" + this.sendingUserc.account + ", mail:" + this.sendingUserc.mail);
    //console.log(this.myForm.value);
    this.router.navigate(["/home"]);
  }

  public resetData3(){
    this.cfavoriteColorControlId.setValue('')
    this.cfavoriteColorControlAccount.setValue('')
    this.cfavoriteColorControlMail.setValue('')
  }

  public deleteData(){
    this.userProviderService.deleteUser(this.importedUserc.id).subscribe(data => this.msg=data, error => this.error=error);
    this.router.navigate(["/home"]);
  }

  public printUser(){
    
    //console.log("importedUserb: id:" + this.importedUserb.id + ", account:" + this.importedUserb.account + ", mail:" + this.importedUserb.mail);
    //console.log("sendingUserb: id:" + this.sendingUserb.id + ", account:" + this.sendingUserb.account + ", mail:" + this.sendingUserb.mail);

  }

  public updateValue(){
    
    this.cfavoriteColorControlId.setValue(this.importedUserc.id)
    this.cfavoriteColorControlAccount.setValue(this.importedUserc.account)
    this.cfavoriteColorControlMail.setValue(this.importedUserc.mail)
  }
}
