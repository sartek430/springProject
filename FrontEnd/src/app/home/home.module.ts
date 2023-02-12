import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { FormsModule } from '@angular/forms';
import { UnicornService } from '../services/unicorn.service';
import { HttpClient, HttpHandler } from '@angular/common/http';


@NgModule({
    declarations: [HomeComponent],
    imports: [
        CommonModule,
        HomeRoutingModule,
        FormsModule,
    ],
    exports: [
      HomeComponent
    ],
    providers: [UnicornService, HttpClient]
})
export class HomeModule { }
