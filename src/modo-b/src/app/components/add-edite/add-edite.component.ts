import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { from, of, Observable } from 'rxjs';
import { Select, Store } from "@ngxs/store";

import { UserProviderService } from '../../services/user-provider.service';
import { StatoModule } from '../../modules/stato/stato.module';
import { User } from '../../models/user';

import { UserStatoModel, BozzaUserStatoModel, BozzaUserStatoModelRequest } from '../../modules/stato/stato-model.module';
import { GetUsers, GetUser, CreateUser, UpdateUser, DeleteUser } from '../../modules/stato/stato-action.module';


@Component({
  selector: 'app-add-edite',
  templateUrl: './add-edite.component.html',
  styleUrls: ['./add-edite.component.css']
})
export class AddEditeComponent implements OnInit {
  @Input('parentUsere') public importedUsere:User = new User("","");
  @Output() public childUsere = new EventEmitter();

  public sendingUsere:User=new User("","");
  public error: string = "";
  public msg: String = "";

  public stringe: String = "";

  
  newItemForm: FormGroup;
  isShowNewItemForm: boolean = false;

  

  constructor(
    private store: Store, private fb: FormBuilder,
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
  ) { 

    this.newItemForm = this.fb.group({
      eid:[0],
      eaccount: ["", Validators.required],
      email: [""]
    });
  }

  ngOnInit(): void {
    //localStorage.setItem("importedUsere",JSON.stringify(this.importedUsere));
    this.stringe = this.importedUsere.id + ":" + this.importedUsere.account + ":" + this.importedUsere.mail ;
    this.newItemForm.controls.bid.setValue(this.importedUsere.id)
    this.newItemForm.controls.baccount.setValue(this.importedUsere.account)
    this.newItemForm.controls.bmail.setValue(this.importedUsere.mail)
  }


  onSubmit() {
    this.store.dispatch(new CreateUser(this.newItemForm.value));
    
    this.isShowNewItemForm = !this.isShowNewItemForm;
  }

  showNewItemForm() {
    this.isShowNewItemForm = !this.isShowNewItemForm;
  }

  cancelForm() {
    this.isShowNewItemForm = !this.isShowNewItemForm;
  }

  public fireChildUser(){
    this.childUsere.emit("User " + this.importedUsere.account + " Saluta");
  }

  public sendData5(){
    
    //this.formModel.id = this.importedUser.id;
    //this.userProviderService.createUser(this.importedUsere).subscribe(data => this.sendingUser=data, error => this.error=error);
    //console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
    
    //this.store.dispatch(new CreateUser(this.newItemForm.value));
    this.store.dispatch(new CreateUser(this.importedUsere));

    this.isShowNewItemForm = !this.isShowNewItemForm;
    this.router.navigate(["/home"]);
  }

  

  public resetData5(){
    this.newItemForm.reset();
  }

  

  public deleteData(){
    //this.userProviderService.deleteUser(this.importedUsere.id).subscribe(data => this.msg=data, error => this.error=error);

    this.store.dispatch(new DeleteUser(this.importedUsere.id));
    this.router.navigate(["/home"]);
  }

  public updateValue(){

  }

  public printUser(){
    
    console.log("importedUser: id:" + this.importedUsere.id + ", account:" + this.importedUsere.account + ", mail:" + this.importedUsere.mail);
    console.log("sendingUsere: id:" + this.sendingUsere.id + ", account:" + this.sendingUsere.account + ", mail:" + this.sendingUsere.mail);
 
  }

  
}
