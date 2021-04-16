import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http'
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from '../models/user';

const httpOptions = {
  headers:new HttpHeaders({'Content-type' : 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class UserProviderService {

  constructor(private http:HttpClient) {}
  //private _url:string="http://localhost:3000/people"
  private _url:string="http://localhost:8080/myuse/api/users";

  public getUsers():Observable<User[]>{
    return this.http.get<User[]>(this._url+"/all", httpOptions).pipe(catchError(this.errorHandler));
  }

  public getUser(id:number):Observable<User>{
        return this.http.get<User>(this._url + "/" + id, httpOptions).pipe(catchError(this.errorHandler));
  }

  public createUser(user:User):Observable<User>{
    return this.http.post<User>(this._url + "/save", user, httpOptions).pipe(catchError(this.errorHandler));
  }

  public updateUser(user:User):Observable<User>{
    return this.http.post<User>(this._url + "/save", user, httpOptions).pipe(catchError(this.errorHandler));
  }

  public deleteUser(id:number):Observable<String>{
    return this.http.get<String>(this._url + "/delete/" + id, httpOptions).pipe(catchError(this.errorHandler));
  }

  errorHandler(error:HttpErrorResponse){
    return throwError(error.message)
  }



}
