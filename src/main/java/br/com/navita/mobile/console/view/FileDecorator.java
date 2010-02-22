package br.com.navita.mobile.console.view;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Date;

public class FileDecorator {
	private File file;

	public FileDecorator(File f) {
		this.file = f;
	}

	public boolean canExecute() {
		return file.canExecute();
	}

	public boolean canRead() {
		return file.canRead();
	}

	public boolean canWrite() {
		return file.canWrite();
	}

	public int compareTo(File pathname) {
		return file.compareTo(pathname);
	}

	public boolean createNewFile() throws IOException {
		return file.createNewFile();
	}

	public boolean delete() {
		return file.delete();
	}

	public void deleteOnExit() {
		file.deleteOnExit();
	}

	public boolean equals(Object obj) {
		return file.equals(obj);
	}

	public boolean exists() {
		return file.exists();
	}

	public File getAbsoluteFile() {
		return file.getAbsoluteFile();
	}

	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	public File getCanonicalFile() throws IOException {
		return file.getCanonicalFile();
	}

	public String getCanonicalPath() throws IOException {
		return file.getCanonicalPath();
	}

	public long getFreeSpace() {
		return file.getFreeSpace();
	}

	public String getName() {
		return file.getName();
	}

	public String getParent() {
		return file.getParent();
	}

	public File getParentFile() {
		return file.getParentFile();
	}

	public String getPath() {
		return file.getPath();
	}

	public long getTotalSpace() {
		return file.getTotalSpace();
	}

	public long getUsableSpace() {
		return file.getUsableSpace();
	}

	public int hashCode() {
		return file.hashCode();
	}

	public boolean isAbsolute() {
		return file.isAbsolute();
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}

	public boolean isFile() {
		return file.isFile();
	}

	public boolean isHidden() {
		return file.isHidden();
	}

	public long lastModified() {
		return file.lastModified();
	}

	public long length() {
		return file.length();
	}

	public String[] list() {
		return file.list();
	}

	public String[] list(FilenameFilter filter) {
		return file.list(filter);
	}

	public File[] listFiles() {
		return file.listFiles();
	}

	public File[] listFiles(FileFilter filter) {
		return file.listFiles(filter);
	}

	public File[] listFiles(FilenameFilter filter) {
		return file.listFiles(filter);
	}

	public boolean mkdir() {
		return file.mkdir();
	}

	public boolean mkdirs() {
		return file.mkdirs();
	}

	public boolean renameTo(File dest) {
		return file.renameTo(dest);
	}

	public boolean setExecutable(boolean executable, boolean ownerOnly) {
		return file.setExecutable(executable, ownerOnly);
	}

	public boolean setExecutable(boolean executable) {
		return file.setExecutable(executable);
	}

	public boolean setLastModified(long time) {
		return file.setLastModified(time);
	}

	public boolean setReadable(boolean readable, boolean ownerOnly) {
		return file.setReadable(readable, ownerOnly);
	}

	public boolean setReadable(boolean readable) {
		return file.setReadable(readable);
	}

	public boolean setReadOnly() {
		return file.setReadOnly();
	}

	public boolean setWritable(boolean writable, boolean ownerOnly) {
		return file.setWritable(writable, ownerOnly);
	}

	public boolean setWritable(boolean writable) {
		return file.setWritable(writable);
	}

	public String toString() {
		return file.toString();
	}

	public URI toURI() {
		return file.toURI();
	}

	public URL toURL() throws MalformedURLException {
		return file.toURL();
	}
	
	public Date getLastModified(){
		return new Date(file.lastModified());
	}
	
	public String getUrl(){
		return "jar://" + file.getAbsolutePath().replace("\\", "/");
	}
	
	public String getEscapeAbsolutePath(){
		return file.getAbsolutePath().replace("\\", "/");
	}
}
