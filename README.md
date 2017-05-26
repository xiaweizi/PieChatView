
#最定义饼状图

![avatar.jpg](http://upload-images.jianshu.io/upload_images/4043475-b97a99df57d78b38.gif?imageMogr2/auto-orient/strip)

###PieChatView 代码:

	public class PieChatView extends View {
	
	    private Paint mPaint;
	
	    private static final String TAG     = "xwz";
	    private              int[]  mColors
	                                        = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080, 0xFFE6B800, 0xFF7CFC00};
	
	    private int mWidth;
	    private int mHeight;
	
	    private List<PieBean> mDatas;
	
	    private int mTotal = 0;
	
	    public PieChatView(Context context) {
	        this(context, null);
	    }
	
	    public PieChatView(Context context, AttributeSet attrs) {
	        this(context, attrs, 0);
	    }
	
	    public PieChatView(Context context, AttributeSet attrs, int defStyle) {
	        super(context, attrs, defStyle);
	        initView(context, attrs, defStyle);
	    }
	
	    private void initView(Context context, AttributeSet attrs, int defStyle) {
	        initPaint();
	        mDatas = new ArrayList<>();
	        initDatas();
	    }
	
	    @Override
	    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	        super.onSizeChanged(w, h, oldw, oldh);
	        // 获取到 view 的最终宽高
	        this.mWidth = w;
	        this.mHeight = h;
	    }
	
	    @Override
	    protected void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	
	        if (null == mDatas) {
	            return;
	        }
	
	        // 将画布移到中心
	        canvas.translate(mWidth / 2, mHeight / 2);
	        float r = (Math.min(mWidth, mHeight) / 2) * 0.8f;
	
	        float   tempAngle = 0;
	        RectF rectF     = new RectF(-r, -r, r, r);
	
	        for (PieBean data : mDatas) {
	            float angle = data.getAngle();
	            mPaint.setColor(data.getColor());
	            // 对每个数据进行绘制
	            canvas.drawArc(rectF, tempAngle, angle, true, mPaint);
	            tempAngle += angle;
	        }
	    }
	
	
	    /**
	     * 设置数据
	     * @param datas
	     */
	    public void setDatas(List<PieBean> datas) {
	        if (null != datas) {
	            mDatas.clear();
	            mDatas.addAll(datas);
	        }
	
	        initDatas();
	        invalidate();
	    }
	
	    /**
	     * 初始化数据
	     */
	    private void initDatas() {
	
	        for (int i = 0; i < mDatas.size(); i++) {
	            // 算出总的值
	            mTotal += mDatas.get(i).getValue();
	            mDatas.get(i).setColor(mColors[i % 8]);
	        }
	
	        for (PieBean data : mDatas) {
	            // 算出百分
	            data.setPercent(data.getValue() * 1f / mTotal);
	            Log.e(TAG, "percent:\t" + data.getPercent() );
	            // 算出旋转的角度
	            data.setAngle(data.getPercent() * 360);
	        }
	        mTotal = 0;
	    }
	
	    /**
	     * 初始化 画笔
	     */
	    private void initPaint() {
	        mPaint = new Paint();
	        mPaint.setColor(mColors[0]);
	        mPaint.setAntiAlias(true);
	    }
	}