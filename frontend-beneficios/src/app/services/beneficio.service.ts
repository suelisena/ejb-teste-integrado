import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


export interface Beneficio {
  id: number;
  nome: string;
  descricao: string;
  valor: number;
  version: number;
}

@Injectable({
  providedIn: 'root'
})
export class BeneficioService {

  private apiUrl = 'http://localhost:9090/api/v1/beneficios';

  constructor(private http: HttpClient) { }


  listar(): Observable<Beneficio[]> {
    return this.http.get<Beneficio[]>(this.apiUrl);
  }

  transferir(de: number, para: number, valor: number): Observable<string> {
    return this.http.get(`${this.apiUrl}/transferir?de=${de}&para=${para}&valor=${valor}`, { responseType: 'text' });
  }
}
