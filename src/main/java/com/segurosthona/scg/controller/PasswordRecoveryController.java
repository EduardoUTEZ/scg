/**
 * 
 * SegrosThona 2013.
 * Crece360.
 * @author Juan Pablo Tosca Villanueva.
 *
 */
package com.segurosthona.scg.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.Encripta;

/**
 * Hitos:
 * 
 *  [OWL 20151019] Se agrega par�metro from a env�o de correo para recuperar contrase�a. Sugerido por JASilva
 *
 */
@Controller
@RequestMapping("recovery")
public class PasswordRecoveryController {

	@Resource
	private MailSender mailSender;
	
	@Resource
	private UsuarioService usuarioService;
	
 	/**
 	 * Metodo para inicializar el proceso de recuperaci�n de contrase�a.
 	 */
	@ResponseBody
	@RequestMapping("initRecovery")
	public ModelAndView recoveryRequest(@RequestParam(required=true) String nombreAcceso,
			HttpServletRequest request){
		
		Usuario user = usuarioService.getUsuarioPorNombreAcceso(nombreAcceso);
		String men = "";
		try {
			if (user != null){
				

				
				SimpleMailMessage smessage = new SimpleMailMessage();
				
				smessage.setFrom("scg@segurosargos.com"); //[OWL 20151019]				
				smessage.setTo(user.getCorreoElectronico());
				smessage.setSubject("Reinicio de contraseña del Sistema Aspira Más.");
				StringBuilder builer = new StringBuilder();
				builer.append("Si solicitaste un reinicio de contraseñaa, visita el siguiente enlace: \n");
				builer.append(request.getRequestURL());
				builer.append("/execute?nombreAcceso=");
				builer.append(Encripta.encripta(nombreAcceso));
				builer.append("\n Si no solicitaste este correo, simplemente ignora este correo.");
				smessage.setText(builer.toString());
				mailSender.send(smessage);
				
				men = "Se han enviado instrucciones a tu correo electrónico para recuperar tu contraseña.";
				
			}else{
				men = "Error: El usuario no existe.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			men = "Ocurrió un error al tratar de enviar el correo electrónico.";
		}
		
		return new ModelAndView("recovery", "mensaje", men);
	}

	/**
	 * Metodo para efectuar el reinicio de la contrase�a.
	 */
	@RequestMapping("initRecovery/execute")
	public ModelAndView recoveryExecute(@RequestParam(required=true) String nombreAcceso){
		
		
		//Obtenemos al usuario:		
		Usuario user = usuarioService.getUsuarioPorNombreAcceso(nombreAcceso);
		//Generamos nueva contraseña:
		String nuevaClave= "";//encripta.getRandomPassword();
		user.setClaveAcceso(com.segurosthona.scg.util.Encripta.encripta(nuevaClave));
		user.setCambioClave(true);
		usuarioService.update(user);

		SimpleMailMessage smessage = new SimpleMailMessage();
		smessage.setFrom("scg@segurosargos.com"); //[OWL 20151019]
		smessage.setTo(user.getCorreoElectronico());
		smessage.setSubject("Nueva contraseña de acceso al Sistema Aspira Más");
		
		StringBuilder builer = new StringBuilder();
		builer.append("Esta es tu nueva contraseña: \n");
		builer.append(nuevaClave);
		smessage.setText(builer.toString());
		
		mailSender.send(smessage);
		String men = "Se ha enviado una nueva contraseña a su correo electrónico.";
		return new ModelAndView("recovery", "mensaje", men);
	}

}
