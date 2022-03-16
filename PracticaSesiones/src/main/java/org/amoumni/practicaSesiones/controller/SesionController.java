package org.amoumni.practicaSesiones.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.amoumni.practicaSesiones.model.Colecciones;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** Representa el controlador de la aplicacion.
 * @author Akram Moumni
 * @version 1.0
*/

@Controller
@RequestMapping("/paso")
public class SesionController{

	/** Metodo que devuelve la primera página de la aplicacion
	 * @param atributosRedirigidos hace referencia a los atributos redirigidos.
	 * @param sesionHttp hace referencia a los atributos que se van a ir guardando en una Lista de la sesion.
	*/
	
	@GetMapping("uno")
	public ModelAndView pasoUno(
			RedirectAttributes atributosRedirigidos,  
				@RequestHeader(required = false) String referer, 
				HttpSession sesionHttp,
				HttpServletRequest solicitudHttp) {
		
		ModelAndView mAV = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) sesionHttp.getAttribute("listaMensajesSesion");

		if (listaMensajes == null) {
			listaMensajes = new ArrayList<String>();
			solicitudHttp.getSession().getAttribute("listaMensajesSesion"); 

		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		mAV.addObject("idSesion", sesionHttp.getId());		
		mAV.addObject("listaMensajes", listaMensajes);
		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		
		mAV.setViewName("datosPersonales");
		return mAV;
	}
	
	/** Metodo que devuelve la primera página de la aplicacion
	 * @param atributosRedirigidos hace referencia a los atributos redirigidos.
	 * @param sesionHttp hace referencia a los atributos que se van a ir guardando en una Lista de la sesion.
	*/
	
	@GetMapping("dos")
	public ModelAndView pasoDos(
			RedirectAttributes atributosRedirigidos,  
				@RequestHeader(required = false) String referer,  
				HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) sesionHttp.getAttribute("listaMensajesSesion");

		if (listaMensajes == null) {
			listaMensajes = new ArrayList<String>();
		}

		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		mAV.addObject("idSesion", sesionHttp.getId());		
		mAV.addObject("listaMensajes", listaMensajes);
		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		
		mAV.setViewName("datosProfesionales");
		return mAV;
	}
	
	/** Metodo que devuelve la primera página de la aplicacion
	 * @param atributosRedirigidos hace referencia a los atributos redirigidos.
	 * @param sesionHttp hace referencia a los atributos que se van a ir guardando en una Lista de la sesion.
	*/
	
	@GetMapping("tres")
	public ModelAndView pasoTres(
			RedirectAttributes atributosRedirigidos, 
				@RequestHeader(required = false) String referer, 
				HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) sesionHttp.getAttribute("listaMensajesSesion");

		if (listaMensajes == null) {
			listaMensajes = new ArrayList<String>();
		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		mAV.addObject("idSesion", sesionHttp.getId());		
		mAV.addObject("listaMensajes", listaMensajes);
		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		
		mAV.setViewName("datosBancarios");
		return mAV;
	}
	
	/** Metodo que devuelve la primera página de la aplicacion
	 * @param atributosRedirigidos hace referencia a los atributos redirigidos.
	 * @param sesionHttp hace referencia a los atributos que se van a ir guardando en una Lista de la sesion.
	*/
	
	@GetMapping("cuatro")
	public ModelAndView pasoCuatro(
			RedirectAttributes atributosRedirigidos, 
				@RequestHeader(required = false) String referer,  
				HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) sesionHttp.getAttribute("listaMensajesSesion");
		
		if (listaMensajes == null) {
			listaMensajes = new ArrayList<String>();
		}

		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		mAV.addObject("idSesion", sesionHttp.getId());		
		mAV.addObject("listaMensajes", listaMensajes);
		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		
		mAV.setViewName("resumen");
		return mAV;
	}

	@PostMapping("guarda-mensaje")
	public ModelAndView guardaMensaje(
				RedirectAttributes atributosRedirigidos,  
				@RequestParam(required = false) String nombre,
				@RequestParam(required = false) String apellidos,
				@RequestParam(required = false) String fechaNacimiento,
				@RequestParam(required = false) String genero,
				@RequestParam(required = false) String pareja,
				@RequestParam(required = false) String hijos,
				@RequestParam(required = false) String nacionalidades,
				@RequestHeader(required = false) String referer, 
				HttpServletRequest solicitudHttp) {
		
		ModelAndView mAV = new ModelAndView();
		
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) solicitudHttp.getSession().getAttribute("listaMensajesSesion");
		
		if (listaMensajes == null) {  
			listaMensajes = new ArrayList<String>(); 
			solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes); 
		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		/* NOMBRE */
		if (nombre == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (nombre.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(nombre);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* APELLIDOS */
		if (apellidos == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (apellidos.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(apellidos);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* FECHA */
		if (fechaNacimiento == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (fechaNacimiento.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(fechaNacimiento);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* GENERO */
		if (genero == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (genero.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(genero);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* PAREJA */
		if (pareja == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (pareja.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(pareja);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* HIJOS */
		if (hijos == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (hijos.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(hijos);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* NACIONALIDADES */
		if (nacionalidades == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (nacionalidades.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(nacionalidades);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes);

		mAV.setViewName("redirect:/paso/dos");
		return mAV;
	}
	
	@PostMapping("guarda-mensaje2")
	public ModelAndView guardaMensaje2(
				RedirectAttributes atributosRedirigidos, 
				@RequestParam(required = false) String departamento,
				@RequestParam(required = false) String salario,
				@RequestParam(required = false) String comentarios,
				@RequestHeader(required = false) String referer, 
				HttpServletRequest solicitudHttp) {
		
		ModelAndView mAV = new ModelAndView();
		
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) solicitudHttp.getSession().getAttribute("listaMensajesSesion");
		
		if (listaMensajes == null) {  
			listaMensajes = new ArrayList<String>();  
			solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes); 
		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		/* DEPARTAMENTO */
		if (departamento == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (departamento.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(departamento);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		/* SALARIO */
		if (salario == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (salario.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(salario);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		/* COMENTARIOS */
		if (comentarios == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (comentarios.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(comentarios);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
	
		solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes);
		
		mAV.setViewName("redirect:/paso/tres");
		return mAV;
	}
	
	/* Tercer Paso */
	
	@PostMapping("guarda-mensaje3")
	public ModelAndView guardaMensaje3(
				RedirectAttributes atributosRedirigidos, 
				@RequestParam(required = false) String cuentaCorriente,
				@RequestHeader(required = false) String referer, 
				HttpServletRequest solicitudHttp) {
		
		ModelAndView mAV = new ModelAndView();
		
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) solicitudHttp.getSession().getAttribute("listaMensajesSesion");
		
		if (listaMensajes == null) { 
			listaMensajes = new ArrayList<String>();  
			solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes); 
		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		/* CUENTA CORRIENTE */
		if (cuentaCorriente == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (cuentaCorriente.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(cuentaCorriente);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes);

		mAV.setViewName("redirect:/paso/cuatro");
		return mAV;
	}
	
	/* Cuarto Paso */
	
	@PostMapping("guarda-mensaje4")
	public ModelAndView guardaMensaje4(
				RedirectAttributes atributosRedirigidos, 
				@RequestParam(required = false) String cuentaCorriente,
				@RequestHeader(required = false) String referer, 
				HttpServletRequest solicitudHttp) {
		
		ModelAndView mAV = new ModelAndView();
		
		@SuppressWarnings("unchecked")
		List<String> listaMensajes = (List<String>) solicitudHttp.getSession().getAttribute("listaMensajesSesion");
		
		if (listaMensajes == null) {  
			listaMensajes = new ArrayList<String>(); 
			solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes); 
		}
		
		if (referer != null) {
			atributosRedirigidos.addAttribute("referer", referer);
		} else {
			atributosRedirigidos.addAttribute("referer", "");
		}
		
		/* CUENTA CORRIENTE */
		if (cuentaCorriente == null) {
			atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el parámetro mensaje");
		} else {
			if (cuentaCorriente.isBlank()) {
				atributosRedirigidos.addAttribute("resultadoAccionNOK", "No se ha recibido el texto del mensaje");
			} else {
				listaMensajes.add(cuentaCorriente);
				atributosRedirigidos.addAttribute("resultadoAccionOK", "El mensaje se añadió correctamente");
			}
		}
		
		solicitudHttp.getSession().setAttribute("listaMensajesSesion", listaMensajes);

		mAV.setViewName("redirect:/paso/cuatro");
		return mAV;
	}
	

	@PostMapping("destruye-sesion")
	public String destruyeSesion(
			RedirectAttributes atributosRedirigidos,
				HttpServletRequest request) {
		
		request.getSession().invalidate();
		atributosRedirigidos.addAttribute("resultadoAccionOK", "La sesión se destruyó (y se volvió a crear una nueva) correctamente");
		
		return "redirect:/paso/uno";
		
	}
}