export class User {
    public id:number=0;
    public account:String;
    public mail:String;

    //constructor(){
    //  this.account="";
    //  this.mail="";
    //}

    constructor(account:String, mail:String ){
      this.account=account;
      this.mail=mail;
  }
}
