package com.ctb.pilot.common.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Multipart {

	private List<FileItem> items;

	@SuppressWarnings("unchecked")
	public Multipart(HttpServletRequest request) throws FileUploadException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		items = upload.parseRequest(request);
	}

	public String getParameter(String name) throws UnsupportedEncodingException {
		FileItem item = findFileItemByName(name);
		return item == null ? null : item.getString("utf8");
	}

	public void saveFile(String name, String filename) throws Exception {
		FileItem item = findFileItemByName(name);
		if (item == null || item.isFormField()) {
			throw new IllegalArgumentException(name);
		}
		item.write(new File(filename));
	}

	public InputStream getInputStream(String name) throws IOException {
		FileItem item = findFileItemByName(name);
		if (item == null || item.isFormField()) {
			throw new IllegalArgumentException(name);
		}
		return item.getInputStream();
	}

	private FileItem findFileItemByName(String name) {
		for (FileItem item : items) {
			if (item.getFieldName().equals(name)) {
				return item;
			}
		}
		return null;
	}

}
