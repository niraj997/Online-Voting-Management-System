import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import { HttpService } from 'src/app/services/http.service';
import {Router} from "@angular/router";
import { ElectionManager } from 'src/app/models/college';

@Component({
  selector: 'app-electionmanager',
  templateUrl: './electionmanager.component.html',
  styleUrls: ['./electionmanager.component.css']
})
export class ElectionmanagerComponent implements OnInit {

  
 electionmanager= new ElectionManager();
  msg = '';

  constructor(private _service: HttpService,private _router: Router) { }

  ngOnInit(): void {
  }


  electionmanagerLogin(){
   
    this._service.loginElectionManager(this.electionmanager).subscribe(
      responseData =>
      {

        
      // window.localStorage.setItem("electionmanager", responseData.name);
      
      console.log("response recived");
      this._router.navigate(["/result"]);
    },
    error =>{
      console.log("exception occured");
      this.msg="Bad credentials,Please enter valid email and password";
    }

    )
  }

}

