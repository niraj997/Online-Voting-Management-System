


import { Component, OnInit } from '@angular/core';
//import { Admin } from 'src/app/models/college';
import { HttpService } from 'src/app/services/http.service';
import {Router} from "@angular/router";
import { AdminForm } from 'src/app/admin';
import {NgForm} from "@angular/forms";
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {



  admin = new AdminForm();
  msg = '';
  
  
  
    constructor(private _service: HttpService,private _router: Router) { }
  
    ngOnInit(): void {
      //this.admin.email = 'kp@getMaxListeners.com';
    }
  
   adminLogin(){
   
      this._service.loginAdmin(this.admin).subscribe(
        responseData =>
        {

          
        window.localStorage.setItem("admin", responseData.name);
        
        console.log("response recived");
        this._router.navigate(["/dashboard"]);
      },
      error =>{
        console.log("exception occured");
        this.msg="Bad credentials,Please enter valid email and password";
      }

      )
    }
  
}
  
  
  
  
  
  