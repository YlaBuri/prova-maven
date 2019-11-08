package br.ucsal.lamis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.model.Reserva;
import br.ucsal.lamis.util.BancoUtil;

public class ReservaDAO {
	static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");

	public static List<Reserva> getReservas() {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		Connection con = BancoUtil.getConnection(); 
		try { 
			String sql="SELECT * FROM RESERVAS;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			ResultSet resultSet=pstmt.executeQuery();

			while(resultSet.next()){ 
				Reserva reserva= new Reserva();
				reserva.setId(resultSet.getInt("reserva_id"));
				reserva.setObjetivo(resultSet.getString("objetivo"));
				reserva.setDescricao(resultSet.getString("descricao"));				 
				reserva.setData(LocalDate.parse(resultSet.getString("dia"), dateFormat));				 							 
				reserva.setHoraInicio(LocalTime.parse(resultSet.getString("hora_inicio"), timeFormat));						  
				reserva.setHoraFinal(LocalTime.parse(resultSet.getString("hora_final"), timeFormat));				 
				reserva.setLaboratorio(LaboratorioDAO.obterLaboratorio(resultSet.getInt("laboratorio_id")));
				reserva.setUsuario(UsuarioDAO.obterUsuario(resultSet.getInt("usuario_id")));
				reservas.add(reserva);
			} 
			resultSet.close(); 
			pstmt.close(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return reservas;
	} 

	public static void inserirReserva(Reserva reserva) {
		Connection con = BancoUtil.getConnection(); 
		try { 
			String sql="INSERT INTO RESERVAS (DIA, HORA_INICIO,HORA_FINAL, OBJETIVO, DESCRICAO, LABORATORIO_ID, USUARIO_ID) VALUES"
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, reserva.getData().format(dateFormat));
			pstmt.setString(2, reserva.getHoraInicio().format(timeFormat));	
			pstmt.setString(3, reserva.getHoraFinal().format(timeFormat));
			pstmt.setString(4, reserva.getObjetivo());
			pstmt.setString(5, reserva.getDescricao());
			pstmt.setInt(6, reserva.getLaboratorio().getId());
			pstmt.setInt(7, reserva.getUsuario().getId());
			pstmt.execute();
			pstmt.close(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
	}

	public static void removerReserva(Integer id) {
		Connection con = BancoUtil.getConnection();
		try { 
			 String sql="DELETE FROM  RESERVAS WHERE RESERVA_ID=?;";
			 PreparedStatement pstmt= con.prepareStatement(sql);
			 pstmt.setInt(1, id);
			 pstmt.executeUpdate();
			 pstmt.close(); 
		 } catch (SQLException e) { 
			 e.printStackTrace(); 
		 } 

	}
}
