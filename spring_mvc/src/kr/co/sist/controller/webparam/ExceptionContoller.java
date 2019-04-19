
package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Calendar;
import java.util.Random;

@Controller
public class ExceptionContoller {

	/**
	 * 예외를 발생하는 메서드.
	 * 
	 * @return 예외가 발생하는 jsp파일.
	 */
	@RequestMapping(value = "/exception/exception.do", method = GET)
	public String exceptionForm() {

		return "exception/exception_form";
	}// exceptionForm()

	/**
	 * NumberFormatException 발생 시키는 메서드.
	 * 
	 * @param age
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/exception/number_format.do", method = GET)
	public String numberFormat(int age, Model model) {

		model.addAttribute("birth", Calendar.getInstance().get(Calendar.YEAR) - age + 1);

		return "exception/view_age";
	}// numberFormat()

	/**
	 * ClassNotFoundException 발생 시키는 메서드.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/exception/class_not_found.do", method = GET)
	public String classNotFound() throws ClassNotFoundException {

		// 난수 발생.
		if (new Random().nextBoolean()) {
			throw new ClassNotFoundException("클래스가 없어서 발새하는 예외");
		} // end if

		return "exception/view_age";
	}// numberFormat()

	/************************ 이하는 예외 처리 메소드들. ***********************/

	/**
	 * 같은 Controller 클래스 내의 method들 중 어떠한 메소드라도 NumberFormatException를 발생시키면 예외를
	 * 처리하는 메서드이다.
	 * 
	 * @return ModelAndView
	 */
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatProcess(NumberFormatException nfe) {

		// ModelAndView : 데이터를 처리하고 값을 jsp에 넘겨주는 객체.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exception/error");
		// mav.addObject("msg", nfe.printStackTrace()); // .printStackTrace() : 사용 불가.
		mav.addObject("msg", nfe.getMessage()); // .getMessage() : 매우 간단한 에러 메세지.
		mav.addObject("exception", nfe.toString()); // .toString() : 예외처리 객체와 간단한 에러 메시지.

		return mav;
	}// numberFormatProcess

	@ExceptionHandler(ClassNotFoundException.class)
	public ModelAndView classNotFoundProcess(ClassNotFoundException cnfe) {

		// ModelAndView : 데이터를 처리하고 값을 jsp에 넘겨주는 객체.
		ModelAndView mav = new ModelAndView();

		// 반환할 jsp파일의 이름을 담아준다.
		mav.setViewName("exception/error");

		mav.addObject("msg", cnfe.getMessage());
		mav.addObject("exception", cnfe.toString());

		return mav;
	}// classNotFoundProcess

}// class
