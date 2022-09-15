package br.com.fiap;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML TextField textFieldNome;
    @FXML TextField textFieldValor;
    @FXML ChoiceBox<String> choiceBoxCategoria;
    @FXML ChoiceBox<String> choiceBoxPagamento;
    @FXML DatePicker datePickerDataDeVencimento;
    @FXML private ListView<Conta> listView;

    private List<Conta> lista = new ArrayList<>();
    
    public void salvar(){
      try{
       var conta = carregarDadosDoFormulario();
        lista.add(conta);

        mostrarAlerta("Conta cadastrada com sucesso");

        limparFormulario();
        
        listView.getItems().add(conta);


      }catch(NumberFormatException erro){
        mostrarAlerta("Valor inválido, digite um valor válido");

      }catch(IllegalArgumentException erro){
        mostrarAlerta("Valor negativo, digite um valor positivo");
      }
    }
    
    private Conta carregarDadosDoFormulario(){
        
        String nome = textFieldNome.getText();

        double valor = Double.valueOf(textFieldValor.getText());
            if(valor <=0){
                 throw new IllegalArgumentException("Número negativo");
            }else{


        String categoria = choiceBoxCategoria.getValue();
        String pagamento = choiceBoxPagamento.getValue();
        LocalDate dataDeVencimento = datePickerDataDeVencimento.getValue();
        var conta = new Conta(nome, valor, categoria, pagamento, dataDeVencimento);
        return conta;
            }
    }

    

    private void limparFormulario(){

        textFieldNome.setText("");
        textFieldValor.setText("");
        datePickerDataDeVencimento.setValue(null);
        choiceBoxCategoria.setValue(null);
        choiceBoxPagamento.setValue(null);
    }

    private void mostrarAlerta(String mensagem){

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setContentText(mensagem);
        alerta.show();
    }

    private void mostrarMensagem(String textoDaMensagem){
        Alert mensagem = new Alert(AlertType.ERROR);
        mensagem.setContentText(textoDaMensagem);
        mensagem.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       choiceBoxCategoria.getItems().addAll(List.of("Luz", "Agua", "Internet", "Plano de saude", "Plano de celular"));
       choiceBoxPagamento.getItems().addAll(List.of("Sim", "Não"));
    }
    
    public void OrdenarPorValor(){
        lista.sort((o1, o2) -> Double.compare(o1.getValor(), o2.getValor()));
        atualizarLista();
    }

    public void OrdenarPorPagamento(){
       
        lista.sort((o1, o2) -> o1.getPagamento().compareTo(o2.getPagamento()));
        atualizarLista();
    }

    public void OrdenarPorCategoria(){

        lista.sort((o1, o2) -> o1.getCategoria().compareTo(o2.getCategoria()));
        atualizarLista();
    }

    public void OrdenarPorDataDeVencimento(){
        lista.sort((o1,o2) -> o1.getDataDeVencimento().compareTo(o2.getDataDeVencimento()));
    }

    private void atualizarLista(){
        listView.getItems().clear();
        listView.getItems().addAll(lista);
    }

    
    }
   


