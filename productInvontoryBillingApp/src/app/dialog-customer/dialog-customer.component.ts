import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-dialog-customer',
  templateUrl: './dialog-customer.component.html',
  styleUrls: ['./dialog-customer.component.css']
})
export class DialogCustomerComponent implements OnInit{
  actionBtn: string='Save';
  CustomerForm!: FormGroup;


  constructor(private formBuilder:FormBuilder) {

  }

  ngOnInit(): void {
    this.CustomerForm=this.formBuilder.group({
      name:['',Validators.required],
      email:['',Validators.required],
    })
  }

  updateCustomer() {

  }

  addCustomer() {

  }
}
