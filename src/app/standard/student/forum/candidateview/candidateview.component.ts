
import { Component, OnInit } from '@angular/core';
import { Candidate } from 'src/app/models/college';
import { HttpService } from 'src/app/services/http.service';
import { Router } from '@angular/router';
import { jsPDF } from "jspdf";

@Component({
  selector: 'app-candidateview',
  templateUrl: './candidateview.component.html',
  styleUrls: ['./candidateview.component.css']
})
export class CandidateviewComponent implements OnInit {
  positions:string[];
 candidate: Candidate[];
   
  // candidate = new Candidate();
  constructor(private _service:HttpService,private _router:Router,  ) { }
  // constructor(private _service:HttpService,private _router:Router, private popup:Popup ) { }
  ngOnInit(): void {
    this._service.fetchCandidateList().subscribe(
      data => {
        console.log("response recieved", data);
        this.candidate = data;
      },
      error=>console.log("exception occured")
    ) 
     this._service.fetchAllPosition().subscribe(
      data => {
        console.log("response recieved", data);
        this.positions = data;
      }
     )
    }
    back(){
      console.log('go back');
      this._router.navigate(['forum']);
    }
  
    
    getCandidateByPosition(position : string){
    this._service.fetchCandidateByPosition(position).subscribe(
   
       data => {
        console.log("Response recieved",data);
    this.candidate = data;
     },
       error=>console.log("Exception occurred")


    )

  }
    voteCandidate(candidate_id: number){
      this._service.voteCandidateById(candidate_id).subscribe(

        data =>{
          console.debug("Succussfully Voted");
          
          alert("Confirm your VOTE ?");
          // this._router.navigate(['candidateview'])
        }
      )
      
   
}
logout(){
  console.log('go back');
  sessionStorage.removeItem('email');
  // sessionStorage.removeItem('password');
  this._router.navigate(['student']);

}
downloadPdf(){

const doc = new jsPDF();
doc.text('Guidelines For Student Council Election 2020-21',10,10);
doc.text('This is client-side Javascript, pumping out a PDF.',20,20);

 doc.save('Guidelines.pdf');
//  doc.text(20, 20, 'Hello world!');
//         // doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');
        // doc.addPage();
        // doc.text(20, 20, 'Do you like that?');
//         var doc = new jsPDF();
// doc.setFontSize(22);
// doc.text(20, 20, 'This is a title');

// doc.setFontSize(16);
// doc.text(20, 30, 'This is some normal sized text underneath.');	

// // Output as Data URI
// doc.output('datauri');


}

}