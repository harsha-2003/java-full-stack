package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.Notice;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.University;
import com.klef.jfsd.springboot.service.AdminServiceImpl;
import com.klef.jfsd.springboot.service.CounsellerService;
import com.klef.jfsd.springboot.service.CounsellerServiceImpl;
import com.klef.jfsd.springboot.service.NoticeService;
import com.klef.jfsd.springboot.service.StudentService;
import com.klef.jfsd.springboot.service.StudentServiceImpl;
import com.klef.jfsd.springboot.service.UniversityServiceImpl;
import java.sql.Blob;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private CounsellerServiceImpl counsellerService;
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private UniversityServiceImpl universityServiceImpl;
	@Autowired
	private NoticeService noticeService;
	@GetMapping("/") 
	public String main() 
	{ 
		return "index"; 
	} 
	@GetMapping("about")
	public String about()
	{
		return "about";
	}
	@GetMapping("contactus")
	public String contactus()
	{
		return "contactus";
	}
	@GetMapping("login")
	public String login()
	{
		return "login";
	}
	private int id;
	@PostMapping("userdashboard")
	public ModelAndView loginUser(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String email = request.getParameter("email");
	    String pwd = request.getParameter("pwd");
	    Counseller c = counsellerService.dashboard(email, pwd);
	    Student s = studentService.dashboard(email, pwd);
	    Admin a = adminServiceImpl.dashboard(email, pwd);
	    if(c!=null)
	    {
	    	HttpSession session = request.getSession();
	    	
	    	session.setAttribute("id", c.getId()); 
	    	id = c.getId();
	    	List<Notice> nlist = noticeService.viewNotices(id);
	    	session.setAttribute("username", c.getName());
	    	session.setAttribute("counseller", c);
	    	Collections.reverse(nlist);
//	    	byte [] imageBytes = null;
//	    	  imageBytes = product.getProductimage().getBytes(1,(int) product.getProductimage().length());
//	    	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	    	mv.setViewName("counsellerprofile");
	    	mv.addObject("nlist", nlist);
	    }
	    else if(s!=null)
	    {
	    	
	    	HttpSession session = request.getSession();
	    	
	    	session.setAttribute("id", s.getId()); 
	    	session.setAttribute("username", s.getName());
	    	session.setAttribute("counselor", s.getAssignedCounselor().getName());
	        session.setAttribute("counselorid",s.getAssignedCounselor().getId());
	        int cid = (int) session.getAttribute("counselorid");
	        List<Notice> nlist = noticeService.viewNotices(cid);
	        for(Notice n : nlist)
	        {
	        	System.out.println(n.getId());
	        }
	    	mv.setViewName("studentprofile");
	    	Collections.reverse(nlist);
	    	mv.addObject("nlist", nlist);
	    }
	    else if(a!=null)
	    {
	    	HttpSession session = request.getSession();
	    	
	    	session.setAttribute("id", a.getId()); 
	    	session.setAttribute("username", a.getName());
	    	mv.setViewName("adminprofile");
	    }
	    else {
	    	mv.setViewName("login");
	    }
	    return mv;
	}
	@GetMapping("register")
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView();
		List<University> unilist = universityServiceImpl.viewuniversities();
		mv.addObject("unilist", unilist);
		//for(University u : unilist) System.out.println(u.getName()+" "+u.getId());
		mv.setViewName("register");
		return mv;
	}
	@PostMapping("registeruser")
	public ModelAndView registeruser(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String msg = null;
		try
		{
			String uname = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String college = request.getParameter("college");
			String gender = request.getParameter("gender");
//			String role = request.getParameter("role");
			//System.out.println(uname+" "+email+" "+role+" ");

				Student s = new Student();
				s.setName(uname);
				s.setEmail(email);
				s.setPassword(password);
		  		s.setCollege(college);
		  		s.setGender(gender);
				msg = studentService.addStudent(s);
				mv.setViewName("login");
		}
		catch(Exception e)
		{
			//System.out.println(uname+" "+email+" "+password+" ");
			msg=e.getMessage(); 
			System.out.println(msg);
		   mv.setViewName("register"); 
	       mv.addObject("message", msg);
		}
		return mv;
	}

	@GetMapping("registerCounseller")
	public ModelAndView addCounseller()
	{
		ModelAndView mv =new ModelAndView(); 
		mv.setViewName("regcounseller"); 
		List<University> unilist = universityServiceImpl.viewuniversities();
		mv.addObject("unilist", unilist);
		//for(University u : unilist) System.out.println(u.getName()+" "+u.getId());
		return mv;
	}
	@PostMapping("registercounseller")
	public ModelAndView registercounseller(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String msg = null;
		try
		{
			String uname = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String college = request.getParameter("college");
			String gender = request.getParameter("gender");

			Counseller c = new Counseller();
			c.setName(uname);
			c.setEmail(email);
			c.setPassword(password);
			c.setCollege(college);
			c.setGender(gender);
			msg = adminServiceImpl.addCounseller(c);
			mv.setViewName("regcounseller");
		}
		catch(Exception e)
		{
			//System.out.println(uname+" "+email+" "+password+" ");
			msg=e.getMessage(); 
			System.out.println(msg);
		   mv.setViewName("regcounseller"); 
	       mv.addObject("message", msg);
		}
		return mv;
	}
	@GetMapping("registerUniversity")
	public ModelAndView addUniversity()
	{
		ModelAndView mv =new ModelAndView(); 
		mv.setViewName("addinstitute"); 
		return mv;
	}
	@PostMapping("registeruniversity")
	public ModelAndView registeruniversity(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String msg = null;
		try
		{
			String id = request.getParameter("id");
			int uid = Integer.parseInt(id);
			String uname = request.getParameter("universityname");
			String password = request.getParameter("password");
			University u = new University();
			u.setId(uid);
			u.setName(uname);
			msg = universityServiceImpl.addUniversity(u);
			mv.setViewName("adminprofile");
		}
		catch(Exception e)
		{
			//System.out.println(uname+" "+email+" "+password+" ");
			msg=e.getMessage(); 
			System.out.println(msg);
		   mv.setViewName("addinstitute"); 
	       mv.addObject("message", msg);
		}
		return mv;
	}
	@GetMapping("studentList")
	public ModelAndView showStudentRecords(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		List<Student> slist = studentService.viewStudentsByCid(id);
		mv.setViewName("studentlists");
		mv.addObject("slist", slist);
		return mv;
	}
	@GetMapping("addnotice")
	public ModelAndView addnoticedemo(HttpServletRequest request)
	   {
		   ModelAndView mv = new ModelAndView("addnotice");
		   HttpSession session = request.getSession();
		   Counseller counselor = (Counseller) session.getAttribute("counseller");
		   return mv;
	   }
	@PostMapping("addnoticer")
	   public ModelAndView addnoticer(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws IOException, SerialException, SQLException
	   {
		   String msg = null;
		   
		   ModelAndView mv = new ModelAndView();
		   
		   HttpSession session = request.getSession();		   
		   try
		   {
		   String title = request.getParameter("title");
		   String content = request.getParameter("content");
		   
			  byte[] bytes = file.getBytes();
			  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			  Counseller counselor = (Counseller) session.getAttribute("counseller");
			  Notice n = new Notice();
			  n.setContent(content);
			  n.setTitle(title);
			  n.setFileName(blob);
			  //System.out.print(counselor);
			  if(counselor!=null)
				  n.setCounselor(counselor);
			  noticeService.addNotice(n);
			  mv.setViewName("addnotice");
		   }	  
		   catch(Exception e)
		   {
			   msg = e.getMessage();
			   System.out.println(msg.toString());
			   mv.setViewName("addnotice");
		   }
		   return mv;
	   } 
	@GetMapping("/downloadFile/{noticeId}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable Long noticeId) throws SQLException {
	    // Retrieve the notice from the database based on the noticeId
	    Notice notice = null;
		try {
			notice = noticeService.getNoticeById(noticeId);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Implement this method

	    if (notice != null) {
	        try {
	            Blob blob = notice.getFileName();

	            // Convert Blob to byte array
	            byte[] bytes = blob.getBytes(1, (int) blob.length());

	            // Set the file's content type
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

	            // Provide a filename for the downloaded file
	            headers.setContentDispositionFormData("attachment", notice.getTitle() + ".pdf");

	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	        } catch (Exception e) {
	            // Handle any exceptions (e.g., IOException, SQLException) appropriately
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    } else {
	        // Handle the case where the notice with the given ID is not found
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}

}
