import { Component, OnInit } from '@angular/core';
import { UserProviderService } from '../../services/user-provider.service';
import { User } from '../../models/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public id:number=0;
  public user:User=new User("","");
  public userList:User[]=[];
  public error: string = "";
  public title: string = "modo-b";
  public messageFromUser: string = "";
  public messageFromUserb: string = "";
  public messageFromUserc: string = "";
  public messageFromUserd: string = "";
  public messageFromUsere: string = "";
  public messageFromList: string = "";

  constructor(
    private userProviderService:UserProviderService,
    private route: ActivatedRoute, 
    private router:Router
    ) { }

  ngOnInit(): void {
    if (this.route.snapshot.paramMap.get('id')) {
      this.id= parseInt(this.route.snapshot.paramMap.get('id') || "0");
      this.userProviderService.getUser(this.id).subscribe(data => this.user=data, error => console.log(error));  
      localStorage.setItem("id",JSON.stringify(this.id));
      localStorage.setItem("user",JSON.stringify(this.user));
    }else{
      this.userProviderService.getUsers().subscribe(data => this.userList=data, error => this.error=error);
      
      localStorage.setItem("userList",JSON.stringify(this.userList));
    }

  }

  
  public printHome(){
    var us:string = localStorage.getItem("user") || "";
    var usl:string = localStorage.getItem("userList") || "";
    console.log("us:" + us);
    console.log("usl:" + usl);
    const jus=JSON.parse(us);
    const jusl=JSON.parse(usl);
    console.log("jus:" + jus);
    console.log("jusl:" + jusl);
    //console.log("formModel: id:" + this.formModel.id + ", account:" + this.formModel.account + ", mail:" + this.formModel.mail); 

    
  }

}
