import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-add-editb',
  templateUrl: './add-editb.component.html',
  styleUrls: ['./add-editb.component.css']
})
export class AddEditbComponent implements OnInit {

  @Input('parentUserb') public importedUserb:User = new User("","");
  @Output() public childUserb = new EventEmitter();

  myForm:FormGroup;

  public sendingUserb:User=new User("","");
  public error: string = "";
  public msg: String = "";

  public stringb: String = "";

  constructor(
    private fb:FormBuilder,
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
  ) { 
    this.myForm = fb.group({
      bid:[0],
      baccount: ["", [Validators.required, Validators.maxLength(20)]],
      bmail:["", [Validators.required, Validators.maxLength(20)]]
    });
    //this.myForm = fb.group({
    //  id: [this.importedUserb.id],
    //  account: [this.importedUserb.account, [Validators.required, Validators.maxLength(20)]],
    //  mail:[this.importedUserb.mail, [Validators.required, Validators.maxLength(20)]]
    //});
    //this.myForm.controls.account.setValue(this.importedUserb.account);
    //this.myForm.controls.mail.setValue(this.importedUserb.mail);
  }

  ngOnInit(): void {
    localStorage.setItem("importedUserb",JSON.stringify(this.importedUserb));
    this.stringb = this.importedUserb.id + ":" + this.importedUserb.account + ":" + this.importedUserb.mail ;
    //this.myForm.get("id")?.setValue(this.importedUserb.id)

    this.myForm.controls.bid.setValue(this.importedUserb.id)
    this.myForm.controls.baccount.setValue(this.importedUserb.account)
    this.myForm.controls.bmail.setValue(this.importedUserb.mail)
  }

  public fireChildUser(){
    this.childUserb.emit("User " + this.importedUserb.account + " Saluta");
  }


  public sendData2(){
    
    //this.sendingUser.id=this.formModel.id;
    this.sendingUserb.account = this.myForm.get("baccount")?.value ;
    this.sendingUserb.mail = this.myForm.get("bmail")?.value ;
    console.log("sendingUserb: id:" + this.sendingUserb.id + ", account:" + this.sendingUserb.account + ", mail:" + this.sendingUserb.mail);
    
    this.userProviderService.createUser(this.sendingUserb).subscribe(data => this.sendingUserb=data, error => this.error=error);
    console.log("sendingUserb: id:" + this.sendingUserb.id + ", account:" + this.sendingUserb.account + ", mail:" + this.sendingUserb.mail);
    console.log(this.myForm.value);
    this.router.navigate(["/home"]);
  }

  public resetData2(){
    this.myForm.reset();
  }

  public deleteData(){
    this.userProviderService.deleteUser(this.importedUserb.id).subscribe(data => this.msg=data, error => this.error=error);
    this.router.navigate(["/home"]);
  }

  public printUser(){
    
    console.log("importedUserb: id:" + this.importedUserb.id + ", account:" + this.importedUserb.account + ", mail:" + this.importedUserb.mail);
    console.log("sendingUserb: id:" + this.sendingUserb.id + ", account:" + this.sendingUserb.account + ", mail:" + this.sendingUserb.mail);

  }

  public updateValue(){
    
    this.myForm.controls.bid.setValue(this.importedUserb.id)
    this.myForm.controls.baccount.setValue(this.importedUserb.account)
    this.myForm.controls.bmail.setValue(this.importedUserb.mail)
  }


}
