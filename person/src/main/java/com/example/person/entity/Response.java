package com.example.person.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @description:
 * @version:1.0
 * @author:武伟
 * @date:2018/11/5
 */
public class Response<T> {

	private Meta meta;
	private T data;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public T getData() {
		return data;
	}

	public Response success() {
		this.meta = Meta.SUCCESS;
		return this;
	}

	public Response success(T data) {
		this.meta = Meta.SUCCESS;
		this.data = data;
		return this;
	}

	public Response failure() {
		this.meta = Meta.Err400;
		return this;
	}

	public Response failure(Meta meta) {
		this.meta = meta;
		return this;
	}

	public Response failure(Meta meta, T data) {
		this.meta = meta;
		this.data = data;
		return this;
	}


	@Override
	public String toString() {
		return new StringBuilder().append("{\"meta\":").append(this.meta.toString())
				.append(",\"data\":").append(this.data != null ? this.data.toString() : "\"\"")
				.append("}").toString();
	}

	/**
	 *
	 */
	public enum Meta {
		/**
		 * 请求成功
		 */
		SUCCESS(200, "请求成功。"),

		/**
		 * 请求错误
		 */
		Err400(400, "请求错误。"),
		Err401(401, "当前请求需要用户验证。"),
		Err404(404, "请求失败，请求所希望得到的资源未被在服务器上发现。"),

		/**
		 * 服务器错误
		 */
		Err500(500, "服务器遇到了一个未曾预料的状况。"),
		Err501(501, "服务器不支持当前请求所需要的某个功能。"),
		Err502(502, "从上游服务器接收到无效的响应。");

		Integer code;
		String message;

		Meta(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		public Integer getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		@JsonCreator
		public static Meta setMeta(JSONObject jsonObject) {
//			JSONObject jsonObject = JSONObject.fromObject(metaString);
			Integer code = Integer.valueOf(jsonObject.getString("code"));
			for (Meta item : Meta.values()) {
				if (item.getCode().equals(code)) {
					return item;
				}
			}
			return null;
		}

		@JsonValue
		public JSONObject getMeta() {
			return JSONObject.parseObject(toString());
		}


		/**
		 * Returns the name of this enum constant, as contained in the
		 * declaration.  This method may be overridden, though it typically
		 * isn't necessary or desirable.  An enum type should override this
		 * method when a more "programmer-friendly" string form exists.
		 *
		 * @return the name of this enum constant
		 */
		@Override
		public String toString() {
			return new StringBuilder()
					.append("{\"code\":\"").append(this.code).append("\",\"message\":\"")
					.append(this.message).append("\"}").toString();
		}
	}

}
