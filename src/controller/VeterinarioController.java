package controller;

import conection.postgreConection;
import dao.VeterinarioDAO;
import registro.Consulta;
import registro.Exame;

public class VeterinarioController {

	postgreConection conection = new postgreConection();
	VeterinarioDAO veterinarioDAO = new VeterinarioDAO(conection);
	
	public boolean cadastrarExame(String nomeCliente, String especieAnimal, String nomeExame, double valor, String data, String hora, String idExame) {
            
            return veterinarioDAO.addExame(nomeCliente, especieAnimal, nomeExame, valor, data, hora, idExame);
	}
        
        public Consulta buscarConsulta(String idConsulta){
            
            return veterinarioDAO.buscarConsulta(idConsulta);
        }
        
        public Exame buscarExame(String idExame){
            
            return veterinarioDAO.buscarExame(idExame);
        }
        
	
}
