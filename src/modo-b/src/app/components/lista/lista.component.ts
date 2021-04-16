import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../models/user';
@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  @Input('parentList') public importedUserList:User[]=[];
  @Output() public childList = new EventEmitter();

  public error: string = "";
  constructor(
    private router:Router
  ) { }

  ngOnInit(): void {
    localStorage.setItem("importedUserList",JSON.stringify(this.importedUserList));
  }

  public fireChildList(){
    this.childList.emit("List Saluta");
  }

  public navigate(id:number){
    this.router.navigate(["/home", id]);
  }

}
