import { Component, OnInit } from '@angular/core';
import { Beneficio, BeneficioService } from '../../services/beneficio.service';

@Component({
  selector: 'app-beneficio-lista',
  templateUrl: './beneficio-lista.component.html',
  styleUrls: ['./beneficio-lista.component.css']
})
export class BeneficioListaComponent implements OnInit {

  beneficios: Beneficio[] = [];


  idOrigem!: number;
  idDestino!: number;
  valorTransferir: number = 0;

  constructor(private service: BeneficioService) { }

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados() {
    this.service.listar().subscribe(dados => {
      this.beneficios = dados;
    });
  }

  transferir() {
    this.service.transferir(this.idOrigem, this.idDestino, this.valorTransferir)
      .subscribe({
        next: (res) => {
          alert(res); 
          this.carregarDados();
        },
        error: (err) => alert("Erro: " + err.error)
      });
  }
}
