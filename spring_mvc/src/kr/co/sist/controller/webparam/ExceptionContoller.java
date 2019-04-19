
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
	 * ���ܸ� �߻��ϴ� �޼���.
	 * 
	 * @return ���ܰ� �߻��ϴ� jsp����.
	 */
	@RequestMapping(value = "/exception/exception.do", method = GET)
	public String exceptionForm() {

		return "exception/exception_form";
	}// exceptionForm()

	/**
	 * NumberFormatException �߻� ��Ű�� �޼���.
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
	 * ClassNotFoundException �߻� ��Ű�� �޼���.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/exception/class_not_found.do", method = GET)
	public String classNotFound() throws ClassNotFoundException {

		// ���� �߻�.
		if (new Random().nextBoolean()) {
			throw new ClassNotFoundException("Ŭ������ ��� �߻��ϴ� ����");
		} // end if

		return "exception/view_age";
	}// numberFormat()

	/************************ ���ϴ� ���� ó�� �޼ҵ��. ***********************/

	/**
	 * ���� Controller Ŭ���� ���� method�� �� ��� �޼ҵ�� NumberFormatException�� �߻���Ű�� ���ܸ�
	 * ó���ϴ� �޼����̴�.
	 * 
	 * @return ModelAndView
	 */
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatProcess(NumberFormatException nfe) {

		// ModelAndView : �����͸� ó���ϰ� ���� jsp�� �Ѱ��ִ� ��ü.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exception/error");
		// mav.addObject("msg", nfe.printStackTrace()); // .printStackTrace() : ��� �Ұ�.
		mav.addObject("msg", nfe.getMessage()); // .getMessage() : �ſ� ������ ���� �޼���.
		mav.addObject("exception", nfe.toString()); // .toString() : ����ó�� ��ü�� ������ ���� �޽���.

		return mav;
	}// numberFormatProcess

	@ExceptionHandler(ClassNotFoundException.class)
	public ModelAndView classNotFoundProcess(ClassNotFoundException cnfe) {

		// ModelAndView : �����͸� ó���ϰ� ���� jsp�� �Ѱ��ִ� ��ü.
		ModelAndView mav = new ModelAndView();

		// ��ȯ�� jsp������ �̸��� ����ش�.
		mav.setViewName("exception/error");

		mav.addObject("msg", cnfe.getMessage());
		mav.addObject("exception", cnfe.toString());

		return mav;
	}// classNotFoundProcess

}// class
