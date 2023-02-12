
import { catchError, map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Unicorn } from '../model/unicorn.model';
import { BaseHttpService } from './base.http.service';


@Injectable()
export class UnicornService extends BaseHttpService {
  // constants
  private readonly unicornApiUrl: string = 'localhost:8080/unicorns';

  /**
   * Constructeur
   * @param http service http
   * @param _authenticationService servie authentification
   */
  constructor(
    private http: HttpClient
  ) {
    super();
  }

  /**
   * Récupérer toutes les listStucks
   * @returns un tableau de type listStuck
   */
  public getAll(): Observable<Unicorn[]> {
    const url = 'localhost:8080/unicorns'
    return this.http.get<Unicorn[]>(url);
}
}
