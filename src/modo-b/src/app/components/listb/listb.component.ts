import { Component, OnInit } from '@angular/core';

import { Select, Store } from "@ngxs/store";
import { from, of, Observable } from 'rxjs';
import { UserProviderService } from '../../services/user-provider.service';
import { StatoModule } from '../../modules/stato/stato.module';
import { User } from '../../models/user';

import { UserStatoModel, BozzaUserStatoModel, BozzaUserStatoModelRequest } from '../../modules/stato/stato-model.module';
import { GetUsers, GetUser, CreateUser, UpdateUser, DeleteUser } from '../../modules/stato/stato-action.module';


@Component({
  selector: 'app-listb',
  templateUrl: './listb.component.html',
  styleUrls: ['./listb.component.css']
})




export class ListbComponent implements OnInit {

  @Select(StatoModule.getUserList)
  list$: Observable<User[]> | undefined;

  editItemUrl: string = "/home/";
  constructor(
    private store: Store, 
    private userProviderService:UserProviderService
  ) { 


  }

  ngOnInit(): void {

    this.store.dispatch(new GetUsers());
  }


  removeItem(user: User) {
    const isConfirmed = confirm(`Delete ${user.account}`);
    if (!isConfirmed) return;

    this.store.dispatch(new DeleteUser(user.id));
  }

}
