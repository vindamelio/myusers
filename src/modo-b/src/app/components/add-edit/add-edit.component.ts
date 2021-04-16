import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';
import { from, of, Observable } from 'rxjs';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.css']
})
export class AddEditComponent implements OnInit {
  
  @Input('parentUser') public importedUser:User = new User("","");
  @Output() public childUser = new EventEmitter();

  public formModel:User=new User("","");

  public sendingUser:User=new User("","");
  public error: string = "";
  public msg: String = "";

  public stringa: String = "";
  public stringaAccount: String = "";
  public stringaMail: String = "";
  public stringOne: String = "";
  
  public stringChanged: String = "";
  public stringChanging: String = "";
  stringChangedObs: Observable<String> ;

  controlOne = new FormControl('');

  idI : number = 0;
  idInt: any ;

  constructor(
    private route: ActivatedRoute, 
    private router:Router,
    private userProviderService:UserProviderService
    ) {

    //this.user.id = 0;
    //this.copiaDati( this.importedUser,  this.formModel);
    //this.copiaDati( this.importedUser,  this.sendingUser);

    this.stringChangedObs = of(this.stringChanging);
    //this.stringChangedObs = from(this.stringChanging);
  }


  ngOnInit(): void {
    localStorage.setItem("importedUser",JSON.stringify(this.importedUser));
    this.stringa = this.importedUser.id + ":" + this.importedUser.account + ":" + this.importedUser.mail ; 

    const obsstringOne = from(this.controlOne.valueChanges);
    obsstringOne.subscribe(val => this.stringOne = val, error => this.error = error,  () => console.log("completa1"));

    this.stringChangedObs.subscribe(val => this.stringChanged = val, error => this.error, () => console.log("completa2") );

    this.battleInit();
    this.idInt = setInterval(() => {
      this.battleInit(); 
    }, 5000);

  }

  ngOnDestroy() {
    if (this.idInt) {
      clearInterval(this.idInt);
    }
  }

  battleInit() {
    this.idI++;
    this.stringChanging = this.idI.toString();
    this.controlOne.setValue(this.idI.toString());
    this.stringChangedObs = of(this.stringChanging);
    //this.stringChangedObs = from(this.stringChanging);
    this.stringChangedObs.subscribe(val => this.stringChanged = val, error => this.error, () => console.log("completa3") );

  }

  
  public fireChildUser(){
    this.childUser.emit("User " + this.importedUser.account + " Saluta");
  }

  public sendData(){
    
    //this.formModel.id = this.importedUser.id;
    this.userProviderService.createUser(this.importedUser).subscribe(data => this.sendingUser=data, error => this.error=error);
    console.log("sendingUser: id:" + this.sendingUser.id + ", account:" + this.sendingUser.account + ", mail:" + this.sendingUser.mail);
    this.router.navigate(["/home"]);
  }

  

  public resetData(){
    this.formModel.id = 0;
    this.formModel.account = "";
    this.formModel.mail = "";
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

function fromEvent(idI:any) {
    
  return new Observable((observer) => {
    observer.next(idI);
  });
}


