//import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { Injectable } from '@angular/core';
import { State, Store } from '@ngxs/store';
import { User } from '../../models/user';

//@NgModule({
//  declarations: [],
//  imports: [
//    CommonModule
//  ]
//})

export class GetUsers { 
  static readonly type = '[User] Get';
  constructor() {}
}

export class GetUser { 
  static readonly type = '[User] GetById';
  constructor(public id: number) {}
}

export class CreateUser { 
  static readonly type = '[User] Create';
  constructor(public user: User) {}
}

export class UpdateUser { 
  static readonly type = '[User] Update';
  constructor(public user: User) {}
}

export class DeleteUser { 
  static readonly type = '[User] Delete';
  constructor(public id: number) {}
}

export class RemoveUser { 
  static readonly type = '[User] Remove';
  constructor(public payload:  { id: number }) {}  
}