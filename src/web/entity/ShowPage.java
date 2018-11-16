package web.entity;
@SuppressWarnings("all")
public class ShowPage {
		private Integer currentpage=1;//当前页
		private Integer totalpages=0;//得到总页数
		private Integer pageSize=2;//设置当前页的最大行记录
		
		public Integer getCurrentpage() {
			return currentpage;
		}
		public void setCurrentpage(Integer currentpage) {
			this.currentpage = currentpage;
		}
		public Integer getTotalpages() {
			return totalpages;	
		}
		public void setTotalpages(Integer totalpages) {
			this.totalpages = totalpages;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		@Override
		public String toString() {
			return "ShowPage [currentpage=" + currentpage + ", totalpages="
					+ totalpages + ", pageSize=" + pageSize + "]";
		}
}
