//import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
//import { Injectable } from '@angular/core';
//import { State } from '@ngxs/store';
import { User } from '../../models/user';

//@NgModule({
//  declarations: [],
//  imports: [
//    CommonModule
//  ]
//})
//export class StatoModelModule { }

export interface UserStatoModel {
  users: User[];
  user: User;
  
}



export interface BozzaUserStatoModel {
  idBozzaUser?: string;
  jsonSchemaUser?: string;
  jsonModelUser?: string;
  
}

export interface BozzaUserStatoModelRequest extends BozzaUserStatoModel {
  statoUser?: boolean;
}
